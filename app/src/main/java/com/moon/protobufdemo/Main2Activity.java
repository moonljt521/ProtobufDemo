package com.moon.protobufdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.protobuf.InvalidProtocolBufferException;

import net.angrycode.bean.BookOuterClass;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BookOuterClass.Book.Builder b = BookOuterClass.Book.newBuilder();

        b.setId(1);
        b.setDesc("desc");
        b.setName("name");

        BookOuterClass.Book book = b.build();

        long a = System.currentTimeMillis();
        byte[] data = book.toByteArray();
        System.out.println("protobuf 序列化："+(System.currentTimeMillis() - a));

        long x = System.currentTimeMillis();
        try {
            BookOuterClass.Book book2 = BookOuterClass.Book.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.println("protobuf 反序列化："+(System.currentTimeMillis() - x));


        long c = System.currentTimeMillis();

        String json = new Gson().toJson(book);

        System.out.println("json 序列化："+(System.currentTimeMillis() - c));


        long d = System.currentTimeMillis();

        new Gson().fromJson(json, BookOuterClass.Book.class);

        System.out.println("json 反序列化："+(System.currentTimeMillis() - d));


        /**
         *  打印结果
         *
         *  04-11 10:45:30.545 1998-1998/? I/System.out: protobuf 序列化：2
            04-11 10:45:30.548 1998-1998/? I/System.out: protobuf 反序列化：1
            04-11 10:45:30.591 1998-1998/? I/System.out: json 序列化：43
            04-11 10:45:30.605 1998-1998/? I/System.out: json 反序列化：8
         *
         */

    }
}
