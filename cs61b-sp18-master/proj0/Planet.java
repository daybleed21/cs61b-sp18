// package proj0;
public class Planet{

   public double xxPos;
   public double yyPos;
   public double xxVel;
   public double yyVel;
   public double mass;
   public String imgFileName;

    public Planet(double xP, double yp, double xv, double yv,double m, String img)
    {
        xxPos = xP;
        yyPos = yp;
        xxVel = xv;
        yyVel = yv;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet b)
    {
        this.xxPos = b.xxPos;
        this.xxVel = b.xxVel;
        this.yyPos = b.yyPos;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    public double calcDistance(Planet b)
    {
       return Math.sqrt(Math.pow((this.xxPos - b.xxPos),2) + Math.pow((this.yyPos - b.yyPos),2));
    }
    public double calcForceExertedBy(Planet b)
    {
       double dis =  this.calcDistance(b);
       double f = 6.67e-11 * this.mass * b.mass / (dis * dis);
       return f;
    }
    public double calcForceExertedByX(Planet b)
    {
        double dis =  this.calcDistance(b);
        double f = 6.67e-11 * this.mass * b.mass / (dis * dis);
        double fx = f * (b.xxPos - this.xxPos)/dis;
        return fx;
    }
    public double calcForceExertedByY(Planet b)
    {
        double dis =  this.calcDistance(b);
        double f = 6.67e-11 * this.mass * b.mass / (dis * dis);
        double fy = f * (b.yyPos - this.yyPos) / dis;
        return fy;
    }
    public double calcNetForceExertedByX(Planet[] bs)
    {
        double fnetx = 0;
        for(Planet b : bs)
        {
            if(!this.equals(b))
                    fnetx += this.calcForceExertedByX(b);
        }
        return fnetx;
    }
    public double calcNetForceExertedByY(Planet[] bs)
    {
        double fnety = 0;
        for(Planet b : bs)
        {
            if(!this.equals(b))
                    fnety += this.calcForceExertedByY(b);
        }
        
        return fnety;
    }
    public void update(double dt, double fnetx, double fnety)
    {
        double ax = fnetx / mass;
        double ay = fnety / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;        
    }
    public void draw()
    {
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}