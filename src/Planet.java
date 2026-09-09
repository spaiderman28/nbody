public class Planet {
    double myXPos;
    double myYPos;
    double myXVel;
    double myYVel;
    double myMass;
    String myFileName;

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

    double calcDistance(Planet p) {
        return Math.sqrt(Math.pow(myXPos-p.myXPos, 2) + Math.pow(myYPos-p.myYPos, 2));
    }

    double calcForceExertedBy(Planet pp) {

    }
}
