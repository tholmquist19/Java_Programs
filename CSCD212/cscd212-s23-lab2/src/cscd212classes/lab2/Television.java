package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television>{

    private boolean fourk;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart, final int screenSize, final int resolution,
                      final String make){
        if(model == null || screenSize<32 || resolution<720 || make == null)
            throw new IllegalArgumentException("Invalid parameter in constructor");
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
        if(resolution>=2160)
            this.fourk = true;
    }

    public Television(final String make, final String model, final boolean smart, final int screenSize,
                      final int resolution){
        if(model == null || screenSize<32 || resolution<720 || make == null)
            throw new IllegalArgumentException("Invalid parameter in constructor");
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
        if(resolution>=2160)
            this.fourk = true;
    }

    public String getMake(){
        return this.make;
    }
    public String getModel(){
        return this.model;
    }
    public int getScreenSize(){
        return this.screenSize;
    }
    public int getResolution(){
        return this.resolution;
    }

    public String toString(){
        if(smart == true && fourk==true)
            return getMake()+"-"+getModel()+", "+getScreenSize()+" inch smart tv with 4K resolution";
        if(smart == true && fourk==false)
            return getMake()+"-"+getModel()+", "+getScreenSize()+" inch smart tv with "+getResolution()+" resolution";
        if(smart == false && fourk==true)
            return getMake()+"-"+getModel()+", "+getScreenSize()+" inch tv with 4K resolution";
        else
            return getMake()+"-"+getModel()+", "+getScreenSize()+" inch tv with "+getResolution()+" resolution";
    }
    @Override
    public int compareTo(Television o) {
        if(o==null)
            throw new IllegalArgumentException("null parameter in the compareTo method");
        if(this.make.equals(o.make)) {
            if (this.model.equals(o.model))
                return this.screenSize-o.screenSize;
            else
                return CharSequence.compare(this.model, o.model);
        }
        return CharSequence.compare(this.make, o.make);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Television)) return false;
        Television that = (Television) o;
        return fourk == that.fourk && resolution == that.resolution && screenSize ==
                that.screenSize && smart == that.smart && make.equals(that.make) && model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return this.make.hashCode()+this.model.hashCode()+
                this.resolution+Boolean.hashCode(this.smart)+Boolean.hashCode(this.fourk);
    }
}
