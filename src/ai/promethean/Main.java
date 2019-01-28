package ai.promethean;
import ai.promethean.DataModel.*;

import java.util.SplittableRandom;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World");
        BooleanProperty np= new BooleanProperty("doorOpen",  true);
        System.out.println(np);

        Resource r1= new Resource("Time",60.0);
        Resource r2= new Resource("Time", 70.0);
        System.out.println(r1.equals(r2));

        NumericalProperty np1= new NumericalProperty("doorOpen",1.0);
        BooleanProperty np2= new BooleanProperty("doorClosed",  false);
        System.out.println(np.equals(np2));

        SystemState s= new SystemState(1);
        s.addProperty(np1);

        System.out.println(s.getProperties());
        s.sortProperties();
        System.out.println(s.getProperties());
        s.addResource(r1);
        s.addProperty(np2);

        SystemState s1= new SystemState(2);
        s1.addProperty(np1);
        s1.addProperty(np2);
        s1.addResource(r1);
        System.out.println(s.equals(s1));
        System.out.println(s);

        Optimization o= new Optimization("Time", true);
        System.out.println(o);

        Perturbation perturbation = new Perturbation();
        perturbation.addProperty(np);
        perturbation.addResource(r1);
        System.out.println(perturbation);

    }
}
