public class Node {
    private Registro info;
    private Node prox;

    public Node() {
        this.info = null;
        this.prox = null;
    }


    public Registro getRegistro() {
        return info;
    }

    public void setRegistro(Registro info) {
        this.info = info;
    }

    public Node getProx() {
        return prox;
    }

    public void setProx(Node prox) {
        this.prox = prox;
    }


}
