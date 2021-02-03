public class NBody {
    
    public static double readRadius(String fileName) {
        In in = new In(fileName);
         
        int numberOfPlanets = in.readInt();
		double radiusOfUniverse = in.readDouble();
		return radiusOfUniverse;
    }

    public static Body[] readBodies(String fileName) {
        In in = new In(fileName);
        int numberOfPlanets = in.readInt();
        double radiusOfUniverse = in.readDouble();

		Body[] res = new Body[numberOfPlanets];
        for (int i = 0; i < numberOfPlanets; i++) {
            res[i] = new Body(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return res;
    }

    public static void main (String[] args) {
        double T = Double.parseDouble(args[0]) ;
        double dt = Double.parseDouble(args[1]) ;
        String filename = args[2];
        StdDraw.setScale(-readRadius(filename), readRadius(filename));
        //StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
        
        for (int i =0; i < readBodies(filename).length; i++) {
            readBodies(filename)[i].draw();
        }
        StdDraw.enableDoubleBuffering();
        
        Body[] allplanets = readBodies(filename);
        
        for (double time = 0.0; time <= T; time += dt) {

            double[] xForces = new double[allplanets.length];
            double[] yForces = new double[allplanets.length];

            for (int i =0; i < allplanets.length; i++) {
                xForces[i] = allplanets[i].calcNetForceExertedByX(allplanets);
            }
            for (int i =0; i < allplanets.length; i++) {
                yForces[i] = allplanets[i].calcNetForceExertedByY(allplanets); 
            }

            for (int i =0; i < allplanets.length; i++) {
            allplanets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i =0; i < allplanets.length; i++) {
                allplanets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", allplanets.length);
        StdOut.printf("%.2e\n", readRadius(filename));
        for (int i = 0; i < allplanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        allplanets[i].xxPos, allplanets[i].yyPos, allplanets[i].xxVel,
                        allplanets[i].yyVel, allplanets[i].mass, allplanets[i].imgFileName);   
        };
        
    }


    
}