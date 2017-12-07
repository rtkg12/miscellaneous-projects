public class Fraction {
    private int num;
    private int den;

    public Fraction(int numerator, int denominator){
        if(denominator==0){
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        else{
            if(denominator<0){
                numerator = numerator * -1;
                denominator = denominator * -1;
            }

            this.num = numerator;
            this.den = denominator;
        }
    }

    public Fraction(int numerator){
        this(numerator, 1 );
    }

    public Fraction(){
        this(0, 1);
    }

    public int getNumerator(){
        return num;
    }

    public int getDenominator(){
        return den;
    }

    public String toString(){
        return num + "/" + den;
    }

    public double toDouble(){
        return (double) num / den;
    }

    public Fraction add(Fraction other){
        int newnum;
        int newden;

        newden = other.getDenominator() * this.getDenominator();
        newnum = (other.getNumerator()*this.getDenominator()) + (this.getNumerator()* other.getDenominator());

        Fraction newfraction = new Fraction(newnum, newden);
        newfraction.toLowestTerms();

        return newfraction;

    }

    public Fraction subtract(Fraction other){
        int newnum;
        int newden;

        newden = other.getDenominator() * this.getDenominator();
        newnum = (this.getNumerator()* other.getDenominator()) - (other.getNumerator()*this.getDenominator()) ;

        Fraction newfraction = new Fraction(newnum, newden);
        newfraction.toLowestTerms();
        return newfraction;

    }

    public Fraction multiply(Fraction other){
        int newnum;
        int newden;

        newden = other.getDenominator() * this.getDenominator();
        newnum = this.getNumerator() * other.getNumerator() ;

        Fraction newfraction = new Fraction(newnum, newden);
        newfraction.toLowestTerms();
        return newfraction;

    }

    public Fraction divide(Fraction other){
        int newnum;
        int newden;

        newden = other.getNumerator() * this.getDenominator();
        newnum = this.getNumerator() * other.getDenominator() ;

        Fraction newfraction = new Fraction(newnum, newden);
        newfraction.toLowestTerms();
        return newfraction;

    }

    public boolean equals(Fraction other){
        this.toLowestTerms();
        other.toLowestTerms();

        if(this.getNumerator() == other.getNumerator() && this.getDenominator()==other.getDenominator()){
            return true;
        }
        else {return false;}
    }

    public void toLowestTerms(){
        int gcd = gcd(this.getNumerator(), this.getDenominator());

        num = num / gcd;
        den = den/gcd;
    }

    public static int gcd(int num, int den){
        while(num!=0 && den!=0){
            int remainder = num % den;
            num = den;
            den = remainder;
        }

        return num;
    }





}
