package exam;

public abstract class Vehicle implements Steerable {

    protected String productId;
    protected Integer weight;

    Vehicle(String productId, int weight) {
        setProductId(productId);
        setWeight(weight);
    }

    Vehicle(String productId) {
        setProductId(productId);
        setWeight(null);
    }

    public Integer getWeight() {
        return this.weight;
    }
    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setWeight(Integer weight) {
        this.weight =  (weight >= 0) ? weight : null;
    }

    @Override
    public String toString() {
        return "Vehicle{productId='" + this.getProductId() + "', weight=" + this.getWeight() + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;

        Vehicle other = (Vehicle) obj;
        if (productId != other.productId)
            return false;

        return true;
    }

}