
package core;

/**
 *
 * @author Jerome Loria
 */
public class Voucher {
    
    private String code;
    private double discount;
    private boolean used;
    
    public Voucher(String code, double discount, boolean used) {
        this.code = code;
        this.discount = discount;
        this.used = used;
    }

    @Override
    public String toString() {
        return code + "," + discount + "," + used + "\n";
    }
    
    public static Voucher parseVoucher(String s) {
        
        String dataArr[] = s.split(",");
        return new Voucher(dataArr[0], 
                Double.parseDouble(dataArr[1]), 
                Boolean.parseBoolean(dataArr[2]));
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
    
    
}
