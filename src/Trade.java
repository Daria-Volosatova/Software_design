import java.io.*;

public class Trade {
    public static void main(String[] args) {
        String type = "";
        try {
            File file = new File(args[0]);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] str = line.split("=");
                str[0] = str[0].replaceAll("\\s+","");
                if (str[0].equals("type")) {
                    type = str[1];
                    System.out.println(str[1]);
                } else if (str[0].equals("price")){
                    switch (type) {
                        case "FX_SPOT":
                            FX_SPOT fx_spot = new FX_SPOT();
                            fx_spot.getPrice(Integer.parseInt(str[1]));
                            break;
                        case "BOND":
                            BOND bond = new BOND();
                            bond.getPrice(Integer.parseInt(str[1]));
                            break;
                        case "COMMODITY_SPOT":
                            COMMODITY_SPOT commodity_spot = new COMMODITY_SPOT();
                            commodity_spot.getPrice(Integer.parseInt(str[1]));
                            break;
                        case "IR_SWAP":
                            IR_SWAP ir_swap = new IR_SWAP();
                            ir_swap.getPrice(Integer.parseInt(str[1]));
                            break;
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
