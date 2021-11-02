package sc.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssetConfig {
    private String typeName;
    private BigDecimal ratio;
    private String ratioStr;
    List<ModelProduct> modelProducts = Lists.newArrayList();

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ModelProduct {
        private Long productId;
        private String productName;
        private BigDecimal ratioModel;
        private Long modelId;
    }

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    private static class ProductInfo {
        private Long productId;
        private String fundType;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    enum FundType {
        STOCK("STOCK", "股票类"),
        BOND("BOND", "债券"),
        MIXED("MIXED", "混合类");
        private String fundType;
        private String desc;

        public static String getByFundType(String fundType) {
            FundType[] values = FundType.values();
            Optional<FundType> first = Arrays.stream(values).filter(a -> fundType.equalsIgnoreCase(a.getFundType())).findFirst();
            return first.get().getDesc();
        }
    }

    public static void main(String[] args) {
        //优化，先分组，再计算
        Map<Long, String> productIdFundTypeMap = info.stream().collect(Collectors.toMap(ProductInfo::getProductId, ProductInfo::getFundType));
        Map<Long, List<ModelProduct>> collect = data.stream().collect(Collectors.groupingBy(ModelProduct::getModelId));
        Set<Map.Entry<Long, List<ModelProduct>>> entries = collect.entrySet();
        for (Map.Entry<Long, List<ModelProduct>> entry : entries) {
            List<AssetConfig> list = Lists.newArrayList();
            List<ModelProduct> value = entry.getValue();
            Map<String, List<ModelProduct>> map = value.stream().collect(Collectors.groupingBy(a -> productIdFundTypeMap.get(a.getProductId())));
            Set<Map.Entry<String, List<ModelProduct>>> entries1 = map.entrySet();
            for (Map.Entry<String, List<ModelProduct>> stringListEntry : entries1) {
                List<ModelProduct> value1 = stringListEntry.getValue();
                AssetConfig assetConfig = new AssetConfig();
                assetConfig.setTypeName(AssetConfig.FundType.getByFundType(productIdFundTypeMap.get(value1.get(0).getProductId())));
                // assetConfig.setRatio(value1.stream().collect(Collectors.summingDouble()));  //TODO 求和，排序
                value1.sort(Comparator.comparing(ModelProduct::getRatioModel));
                assetConfig.setModelProducts(value1);
                list.add(assetConfig);
            }
            list.sort(Comparator.comparing(AssetConfig::getRatio));
            System.out.println(list);
        }

        /*//根据fundType分类，统计大类的百分比
        Map<Long, String> productIdFundTypeMap = info.stream().collect(Collectors.toMap(ProductInfo::getProductId, ProductInfo::getFundType));
        Map<Long, List<ModelProduct>> collect = data.stream().collect(Collectors.groupingBy(ModelProduct::getModelId));

        Set<Map.Entry<Long, List<ModelProduct>>> entries = collect.entrySet();
        for (Map.Entry<Long, List<ModelProduct>> entry : entries) {
            Map<String, AssetConfig> map = Maps.newHashMap();
            List<ModelProduct> value = entry.getValue();
            for (ModelProduct modelProduct : value) {
                String fundType = productIdFundTypeMap.get(modelProduct.getProductId());
                AssetConfig assetConfig = map.get(fundType);
                if (assetConfig == null) {
                    assetConfig = new AssetConfig();
                    assetConfig.setTypeName(AssetConfig.FundType.getByFundType(fundType));
                    assetConfig.setRatio(BigDecimal.ZERO);
                    map.put(fundType, assetConfig);
                }
                assetConfig.getRatio().add(modelProduct.getRatioModel());
                assetConfig.setRatio(assetConfig.getRatio().add(modelProduct.getRatioModel()));
                assetConfig.getModelProducts().add(modelProduct);
            }

            List<AssetConfig> assetConfigList = Lists.newArrayList(map.values());
            assetConfigList.sort(Comparator.comparing(AssetConfig::getRatio).reversed());
            int i = 1;
            for (AssetConfig assetConfig : assetConfigList) {
                System.out.print("大类 " + i++ + " ");
                System.out.println(assetConfig.getTypeName() + "\t" + assetConfig.getRatio().multiply(new BigDecimal(100)) + "%");
                List<ModelProduct> modelProducts = assetConfig.getModelProducts();
                modelProducts.sort(Comparator.comparing(ModelProduct::getRatioModel).reversed());
                for (ModelProduct modelProduct : modelProducts) {
                    System.out.println("\t" + modelProduct.getProductName() + "  " + modelProduct.getRatioModel().multiply(new BigDecimal(100)) + "%");
                }
            }

            System.out.println("=========================== ");
        }*/

    }

    static List<AssetConfig.ModelProduct> data = Arrays.asList(
            ModelProduct.builder().productId(1L).productName("产品1号").ratioModel(new BigDecimal("0.1").setScale(2)).modelId(1L).build(),
            ModelProduct.builder().productId(2L).productName("产品2号").ratioModel(new BigDecimal("0.35").setScale(2)).modelId(1L).build(),
            ModelProduct.builder().productId(3L).productName("产品3号").ratioModel(new BigDecimal("0.15").setScale(2)).modelId(1L).build(),
            ModelProduct.builder().productId(4L).productName("产品4号").ratioModel(new BigDecimal("0.1").setScale(2)).modelId(1L).build(),
            ModelProduct.builder().productId(5L).productName("产品5号").ratioModel(new BigDecimal("0.2").setScale(2)).modelId(1L).build(),
            ModelProduct.builder().productId(6L).productName("产品6号").ratioModel(new BigDecimal("0.3").setScale(2)).modelId(2L).build(),
            ModelProduct.builder().productId(7L).productName("产品7号").ratioModel(new BigDecimal("0.3").setScale(2)).modelId(2L).build(),
            ModelProduct.builder().productId(8L).productName("产品8号").ratioModel(new BigDecimal("0.3").setScale(2)).modelId(2L).build(),
            ModelProduct.builder().productId(9L).productName("产品9号").ratioModel(new BigDecimal("0.1").setScale(2)).modelId(2L).build(),
            ModelProduct.builder().productId(10L).productName("产品10号").ratioModel(new BigDecimal("0.5").setScale(2)).modelId(3L).build(),
            ModelProduct.builder().productId(11L).productName("产品11号").ratioModel(new BigDecimal("0.5").setScale(2)).modelId(3L).build()
    );

    static List<AssetConfig.ProductInfo> info = Arrays.asList(
            ProductInfo.builder().productId(1L).fundType("STOCK").build(),
            ProductInfo.builder().productId(2L).fundType("STOCK").build(),
            ProductInfo.builder().productId(3L).fundType("STOCK").build(),
            ProductInfo.builder().productId(4L).fundType("MIXED").build(),
            ProductInfo.builder().productId(5L).fundType("BOND").build(),
            ProductInfo.builder().productId(6L).fundType("STOCK").build(),
            ProductInfo.builder().productId(7L).fundType("BOND").build(),
            ProductInfo.builder().productId(8L).fundType("MIXED").build(),
            ProductInfo.builder().productId(9L).fundType("BOND").build(),
            ProductInfo.builder().productId(10L).fundType("BOND").build(),
            ProductInfo.builder().productId(11L).fundType("MIXED").build()

    );

}
