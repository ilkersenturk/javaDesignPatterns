package Playground;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataBinding {
    /*
    Jackson has been known as "the Java JSON library" or
    "the best JSON parser for Java". Or simply as "JSON for Java".
     */

    private String jsonPayload;
    private ObjectMapper mapper;

    public DataBinding(){

        mapper =new ObjectMapper();
    }


    public Object toObject(String jsonString, Object objectTo) throws JsonProcessingException {

        return mapper.readValue(jsonString,objectTo.getClass() );
    }

    public String toJsonString(Object object) throws JsonProcessingException {

       return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);

    }

    /*
    Continue on
    https://www.tutorialspoint.com/jackson/jackson_data_binding.htm
     */


    public static void main(String[] args) throws JsonProcessingException {

        String jsonString ="{ \"name\" : \"ilker\", \"age\":36}";
        DataBinding dataBinding = new DataBinding();

        Student newStudent = (Student) dataBinding.toObject(jsonString,new Student());


        System.out.println(newStudent);
    }




























    static class Student {
        private String name;
        private int age;
        public Student(){}

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String toString(){
            return "Student [ name: "+name+", age: "+ age+ " ]";
        }


    }

}
