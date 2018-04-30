/**
 * Created by boreto on 3/17/2017.
 */
public interface Person {
    String getName();
   default String sayHello(){
       return "Hello";
   }

}
