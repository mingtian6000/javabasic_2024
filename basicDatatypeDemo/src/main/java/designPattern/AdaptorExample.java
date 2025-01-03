package designPattern;

class EuropeanToUSAAdapter extends USASocket {
    private EuropeanSocket europeanSocket;

    public EuropeanToUSAAdapter(EuropeanSocket europeanSocket) {
        this.europeanSocket = europeanSocket;
    }

    @Override
    public int voltage() {
        return europeanSocket.voltage() / 2;
    }

    @Override
    public int neutral() {
        return europeanSocket.live();
    }
}

public class AdaptorExample{
    public static void main(String[] args) {
        EuropeanSocket europeanSocket = new EuropeanSocket();
        EuropeanToUSAAdapter adapter = new EuropeanToUSAAdapter(europeanSocket);
        System.out.println("Adapter voltage: " + adapter.voltage());
        System.out.println("Adapter neutral: " + adapter.neutral());
    }

}
class EuropeanSocket{
    int voltage(){
        return 230;
    }
    int live(){
        return 1;
    }
}

class USASocket{
    int voltage(){
        return 120;
    }
    int neutral(){
        return -1;
    }

}