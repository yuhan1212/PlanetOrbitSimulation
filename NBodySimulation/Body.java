public class Body{
    double xxPos; //Its current x position
    double yyPos; //Its current y position
    double xxVel; //Its current velocity in the x direction
    double yyVel; //Its current velocity in the y direction
    double mass; //Its mass
    String imgFileName; //The name of the file that corresponds to the image that depicts the body (for example, jupiter.gif)

    // The signature of the first constructor
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    // The second constructor should take in a Body object and initialize an identical Body object (i.e. a copy).
    public Body(Body B) {
        xxPos = B.xxPos;
        yyPos = B.yyPos;
        xxVel = B.xxVel;
        yyVel = B.yyVel;
        mass = B.mass;
        imgFileName = B.imgFileName;
    }

    public double calcDistance(Body b) {
        double distance = Math.pow(Math.pow((this.xxPos - b.xxPos), 2) + Math.pow((this.yyPos - b.yyPos),2), 0.5);
        return distance;
    }


}