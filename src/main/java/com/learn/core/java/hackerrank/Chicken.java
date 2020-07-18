package com.learn.core.java.hackerrank;
import java.util.concurrent.Callable;


interface Bird {
    Egg lay();
}

public class Chicken implements Bird {
    public Chicken() {
    }

    public Egg lay(){
        Egg egg = new Egg(() -> {return new Chicken();});
        return egg;
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof Bird);
        System.out.println(chicken.lay().hatch() instanceof Chicken);
    }
}

class Egg {

    private Bird bird;
    private boolean hatched = false;

    public Egg(Callable<Bird> createBird) {
        if(createBird!=null) {
            try {
                bird = createBird.call();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public Bird hatch() throws Exception {
        if(!hatched){
            return bird;
        } else {
            throw new IllegalStateException();
        }
    }
}