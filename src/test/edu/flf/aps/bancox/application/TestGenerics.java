package edu.flf.aps.bancox.application;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


class RepositorioX {
	
	
	public void reportType()
  {
      /*Class thisClass = getClass();
      Type[] t = thisClass.getGenericInterfaces();
      ParameterizedType pType = (ParameterizedType)t[0];
      // Since we KNOW this must be a ParameterizedType, we can cast
//      ParameterizedType pType = (ParameterizedType)thisClass.getGenericInterfaces();
      //Type firstType = pType.getActualTypeArguments()[0];
//      Class whatWeWant = (Class)firstType;
//      System.out.println("This example is using type " + whatWeWant.getName() + " for parameter T");
 *
 */
  }
	
}

class Example<T>
{
	@SuppressWarnings("rawtypes")
     public void reportType()
     {
		Class thisClass = getClass();
         // Since we KNOW this must be a ParameterizedType, we can cast
         ParameterizedType pType = (ParameterizedType)thisClass.getGenericSuperclass();
         Type firstType = pType.getActualTypeArguments()[0];
         Class whatWeWant = (Class)firstType;
         System.out.println("This example is using type " + whatWeWant.getName() + " for parameter T");
     }
}

class StringExample extends Example<String> {}


public class TestGenerics {
	public static void main(String[] args) {
//		List<String> lista = new ArrayList<String>();
//		System.out.println(lista.getClass());
//		Type[] pType = (Type[])lista.getClass().getGenericInterfaces();
		
	//String firstType = ((TypeVariable)((ParameterizedType)pType[0]).getActualTypeArguments()[0]).getBounds()
//		
//		
//		
//		Type pType2 = firstType.getClass().getGenericSuperclass();
//		;;Type firstType2 = pType2.getActualTypeArguments()[0];
//		
//		Class whatWeWant = (Class)firstType2;
//		System.out.println("This example is using type " + whatWeWant.getName() + " for parameter T");

		new RepositorioX().reportType();
	}
	
}
