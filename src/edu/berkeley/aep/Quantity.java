package edu.berkeley.aep;
/**
 * Understands length between two points in Imperial Units.
 */
public class Quantity {
    private final double amount;
    private final Unit units;
    public Quantity(double amount, Unit units) {
        this.amount = amount;
        this.units = units;
    }
    public Quantity add(Quantity other, Unit returnType) {
        return new Quantity(this.units.inBase(amount) + other.units.inBase(other.amount), returnType);
    }
    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof Quantity)) return false;
        Quantity otherQuantity = (Quantity) other;
        //return this.units.inBase(amount) == otherQuantity.units.inBase(otherQuantity.amount);
        return this.units.inBase(amount) == otherQuantity.units.convertTo(this.units, (int) otherQuantity.amount);
    }
    @Override
    public int hashCode() {
        return Double.hashCode(amount);
    }
}