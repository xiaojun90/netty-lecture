# 命名空间
namespace java thrift.generated

# 为类型创建别名
typedef i16 short
typedef i32 int
typedef i64 long
typedef string String
typedef bool boolean

struct Person {
    1 : optional String name;
    2 : optional int age;
    3 : optional boolean married;
}

service PersonService{
    #查询用户名
    Person getPersonByName(1: required String name)

    #保存用户信息
    boolean savePerson(1: required Person person)
}
