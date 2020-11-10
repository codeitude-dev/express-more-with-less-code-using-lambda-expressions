/*
 * Copyright 2020 https://codeitude.dev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.codeitude.lambda.expression;

public class ObjectFactory {

    interface MyFactory<R, T> {
        R func(T number);
    }

    static class MyClass<T> {
        private T value;

        MyClass() {
            this.value = null;
        }

        MyClass(T value) {
            this.value = value;
        }

        T getValue() {
            return this.value;
        }
    }

    static class NameClass {
        private String name;

        NameClass(){
            this.name = null;
        }

        NameClass(String name){
            this.name = name;
        }

        String getName(){
            return this.name;
        }
    }

    public static void main(String[] args) {
        MyFactory<MyClass<Integer>, Integer> factory = MyClass<Integer>::new;

        MyClass<Integer> instance = construct(factory, 345);

        System.out.println(instance.getValue());

        MyFactory<NameClass, String> stringFactory = NameClass::new;

        NameClass stringInstance = construct(stringFactory, "Java");

        System.out.println(stringInstance.getName());
    }

    static <R, T> R construct(MyFactory<R, T> factory, T value){
        return factory.func(value);
    }
}
