public class NBody{

    public static double readRadius(String file)
    {
        In in = new In(file);
        in.readInt();
        return in.readDouble();
        
    }
    public static Body[] readBodies(String file)
    {
        In in = new In(file);
        int n = in.readInt();
        in.readDouble();
        Body[] bs = new Body[n];
        for(int i = 0; i < n; i++)
        {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            bs[i] = new Body(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
        }
        return bs;
    }

    public static void main(String[] args)
    {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] bodies = readBodies(filename);
        int n = bodies.length;

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
        StdDraw.picture(0,0,"images/starfield.jpg");
        // System.out.println("already print");
        // for(Body b : bodies)
        // {
        //     b.draw();
        // }
        double time = 0;
        while(time <= T)
        {
            double[] xForces = new double[n];
            double[] yForces = new double[n];
            for(int i = 0; i < n; i++)
            {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            for(int i = 0; i < n; i++)
            {
                bodies[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(Body b : bodies)
            {
                b.draw();
            }

            StdDraw.show(10);


            time += dt;
        }
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) 
        {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
            bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }
    }


}