public class Planet {
    double myXPos;
    double myYPos;
    double myXVel;
    double myYVel;
    double myMass;
    String myFileName;
    private final double G = 6.67 * Math.pow(10,-11);

    public Planet(double xp, double yp, double xv, double yv, double mass, String filename) {
        myXPos = xp;
        myYPos = yp;
        myXVel = xv;
        myYVel = yv;
        myMass = mass;
        myFileName = filename;
    }

    public Planet(Planet p) {
        myXPos = p.myXPos;
        myYPos = p.myYPos;
        myXVel = p.myXVel;
        myYVel = p.myYVel;
        myMass = p.myMass;
        myFileName = p.myFileName;
    }

    double calcDistance(Planet pp) {
        return Math.sqrt(Math.pow(myXPos-pp.myXPos, 2) + Math.pow(myYPos-pp.myYPos, 2));
    }

    double calcForceExertedBy(Planet pp) {
        return G * myMass * pp.myMass / Math.pow(calcDistance(pp), 2);
    }

    double calcForceExertedByX(Planet pp) {
        return calcForceExertedBy(pp) * (pp.myXPos - myXPos) / calcDistance(pp);
    }

    double calcForceExertedByY(Planet pp) {
        return calcForceExertedBy(pp) * (pp.myYPos - myYPos) / calcDistance(pp);
    }

    double calcNetForceExertedByX(Planet[] ppArr) {
        double FnetX = 0;
        for (Planet pp : ppArr) {
            if (this.equals(pp)) continue;
            FnetX += calcForceExertedByX(pp);
        }
        return FnetX;
    }
    double calcNetForceExertedByY(Planet[] ppArr) {
        double FnetY = 0;
        for (Planet pp : ppArr) {
            if (this.equals(pp)) continue;
            FnetY += calcForceExertedByY(pp);
        }
        return FnetY;
    }

    public void update(double seconds, double xForce, double yForce) {
        double xAcc = xForce / this.myMass, yAcc = yForce / this.myMass;
        myXVel += seconds * xAcc; myYVel += seconds * yAcc;
        myXPos += seconds * myXVel; myYPos += seconds * myYVel;
    }
}
