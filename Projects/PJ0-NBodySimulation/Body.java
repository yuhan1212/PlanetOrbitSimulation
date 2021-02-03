public class Body {
    double G = 6.67 * Math.pow(10, -11);
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

    public double calcForceExertedBy(Body b) {
        if (this.equals(b)) {
            return 0.0;
        }
        double force =  G * this.mass * b.mass / Math.pow(this.calcDistance(b),2);
        return force;
    }

    public double calcForceExertedByX(Body b) {
        double forceX = this.calcForceExertedBy(b) * (b.xxPos-this.xxPos) / this.calcDistance(b);
        return forceX;
    }

    public double calcForceExertedByY(Body b) {
        double forceY = this.calcForceExertedBy(b) * (b.yyPos-this.yyPos) / this.calcDistance(b);
        return forceY;
    }

    public double calcNetForceExertedByX(Body[] B) {
        double netXF = 0.0;
        for (int i = 0; i < B.length; i++) {
            if (B[i].equals(this)) {
                continue;
            }
            netXF += this.calcForceExertedBy(B[i]) * (B[i].xxPos-this.xxPos) / this.calcDistance(B[i]);
        }
        return netXF;
    }

    public double calcNetForceExertedByY(Body[] B) {
        double netYF = 0.0;
        for (int i = 0; i < B.length; i++) {
            if (B[i].equals(this)) {
                continue;
            }
            netYF += this.calcForceExertedBy(B[i]) * (B[i].yyPos-this.yyPos) / this.calcDistance(B[i]);
        }
        return netYF;
    }

    public void update(double dt, double fX, double fY) {
        double xxA = fX / this.mass;
        this.xxVel = this.xxVel + dt * xxA;
        this.xxPos = this.xxPos + dt * this.xxVel;
        double yyA = fY / this.mass;
        this.yyVel = this.yyVel + dt * yyA;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
        StdDraw.show();
    }

    public static void main(String[] args) {
        Body samh = new Body (1, 0, 0, 0, 7 * Math.pow(10, 5), null);
        Body aegir = new Body (3, 3, 0, 0, 8 * Math.pow(10, 5), null);
        Body rocinante = new Body (5, -3, 0, 0, 9 * Math.pow(10, 6), null);
        System.out.println(samh.calcForceExertedBy(rocinante));
        System.out.println(samh.calcForceExertedBy(samh));
        System.out.println(samh.calcForceExertedByX(rocinante));
        Body[] allBodys = {samh, rocinante, aegir};
        System.out.println(samh.calcNetForceExertedByX(allBodys));
        System.out.println(samh.calcNetForceExertedByY(allBodys));
        samh.update(0.005, 10, 3);
    } 
        

}