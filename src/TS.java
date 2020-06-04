import vista.Refrescable;

public class TS {
    public static void main(String[] args) {
        Refrescable r=new Refrescable(){
        
            @Override
            public void refresh() {
                // TODO Auto-generated method stub
                
            }
        };
        int orig = 84;

        TS x = new TS();

        int y = x.go(orig);

        System.out.println(orig + " " + y);

    }

    int go(int arg) {

        arg = arg * 2;

        return arg;

    }
}