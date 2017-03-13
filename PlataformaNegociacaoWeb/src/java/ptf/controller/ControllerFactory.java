package ptf.controller;

/**
*
* @author Victor Moraes Ribeiro
*/
public class ControllerFactory {

   public static final Controller getControllerByClass(Class actionClass) {
       try {
           //Cria uma instância de uma classe que implemente a interface Controller a partir de uma classe
           Controller controller = (Controller) actionClass.newInstance();
           return controller;
       } catch (java.lang.InstantiationException e) {
           e.printStackTrace();
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (ClassCastException e) {
           e.printStackTrace();
       }
       return null;
   }

   public static final Controller getControllerByFullClassName(String className) {
       try {
           //Cria uma string contendo o endereço da classe
           String name = "ptf.controllers.concrete." + className + "Controller";
           //Faz o carregamento de uma classe de acordo com a string que foi passada por parâmetro contendo o endereço da classe
           Class actionClass = Class.forName(name);
           //Utiliza um método para retornar uma instância da classe que foi carregada com o Class.forName(name)
           return getControllerByClass(actionClass);
           
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
       return null;
   }

}
