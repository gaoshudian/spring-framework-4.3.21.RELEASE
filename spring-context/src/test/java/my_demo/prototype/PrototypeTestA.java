package my_demo.prototype;

public class PrototypeTestA {

    public String username;

    public PrototypeTestB prototypeTestB;

    public PrototypeTestB getPrototypeTestB() {
        return this.prototypeTestB;
    }

    public void setPrototypeTestB(PrototypeTestB prototypeTestB) {
        this.prototypeTestB = prototypeTestB;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
