# ProtobufDemo

# demo只是演示了下 as上如何使用插件来配置 protobuf 的编译， 手写一个proto文件，编译后生成java文件，来测试它的序列化，反序列化的速度， 然后比较下相同对象的json 序列化，反序列化速度。

## 我打印了一个只含有三个字段的对象的速度比较

##  System.out: protobuf 序列化：2

## System.out: protobuf 反序列化：1

##  System.out: json 序列化：43

##  System.out: json 反序列化：8
