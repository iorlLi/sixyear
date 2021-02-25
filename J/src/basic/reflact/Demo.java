package basic.reflact;

public class Demo {
    @FixFieldDef(order = 1, length = 6)
    private String age;
    @FixFieldDef(order = 2, length = 12)
    private String name;
    @FixFieldDef(order = 3, length = 12)
    private String like;

    public String getAge() {
        return age;
    }

    public Demo(String age, String name, String like) {
        this.age = age;
        this.name = name;
        this.like = like;
    }

    public Demo() {
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", like='" + like + '\'' +
                '}';
    }
}
