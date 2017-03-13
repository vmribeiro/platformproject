package ptf.controller;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Victor Moraes Ribeiro
 */
public abstract class AbstractController implements Controller {

    private HttpServletRequest request;
    protected String returnPage;

    public void init(HttpServletRequest request) {
        this.setRequest(request);
    }

    /**
     * Define a página de resposta
     * @param page 
     */
    public void setReturnPage(String page) {
        returnPage = page;
    }

    public String getReturnPage() {
        return returnPage;
    }

    /**
     * Retorna um objeto com as requisições HTTP
     * @return 
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * Inicializa a variável relacionada às requisições com as requisições passadas por parâmetro
     * @param request 
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

}