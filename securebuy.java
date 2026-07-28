import java.awt.*;
import java.awt.event.*;

public class SecureBuy extends Frame implements ActionListener {

    TextField buyer, seller, platform;
    TextField reviews, followers, amount, otp;

    Checkbox returnPolicy, invoice, oldSeller;

    Button checkSeller, makePayment, verifyOTP;

    TextArea output;

    int trustScore = 0;
    String validOTP = "1234";


    SecureBuy() {

        setTitle("SecureBuy - Smart Payment Protection");
        setSize(700,650);
        setLayout(new FlowLayout());


        Label title = new Label(
        "SECUREBUY - ESCROW PAYMENT PROTECTION");

        title.setFont(new Font("Arial",
        Font.BOLD,18));

        add(title);



        add(new Label("Buyer Name:"));
        buyer = new TextField(20);
        add(buyer);



        add(new Label("Seller Name:"));
        seller = new TextField(20);
        add(seller);



        add(new Label("Platform:"));
        platform = new TextField(20);
        add(platform);



        add(new Label("Followers:"));
        followers = new TextField(10);
        add(followers);



        add(new Label("Reviews:"));
        reviews = new TextField(10);
        add(reviews);



        returnPolicy =
        new Checkbox("Return Policy Available");

        invoice =
        new Checkbox("Invoice Available");

        oldSeller =
        new Checkbox("Verified Old Seller");


        add(returnPolicy);
        add(invoice);
        add(oldSeller);



        checkSeller =
        new Button("Check Seller");

        add(checkSeller);



        add(new Label("Payment Amount:"));

        amount = new TextField(10);
        add(amount);



        makePayment =
        new Button("Make Payment");

        add(makePayment);



        add(new Label("Delivery OTP:"));

        otp = new TextField(10);
        add(otp);



        verifyOTP =
        new Button("Verify OTP");

        add(verifyOTP);



        output = new TextArea(15,55);

        output.setFont(
        new Font("Arial",Font.BOLD,14));

        add(output);



        checkSeller.addActionListener(this);
        makePayment.addActionListener(this);
        verifyOTP.addActionListener(this);



        setVisible(true);



        addWindowListener(new WindowAdapter(){

            public void windowClosing(WindowEvent e){

                System.exit(0);

            }

        });

    }




    public void actionPerformed(ActionEvent e){



        // Seller Verification

        if(e.getSource()==checkSeller){


            trustScore = 0;

            String reason = "";



            try {

                int f =
                Integer.parseInt(followers.getText());

                int r =
                Integer.parseInt(reviews.getText());


                if(f > 500)
                    trustScore += 30;
                else
                    reason += "\n- Low followers";


                if(r > 20)
                    trustScore += 30;
                else
                    reason += "\n- Less reviews";


            }

            catch(Exception ex){

                reason += "\n- Invalid details";

            }



            if(returnPolicy.getState())
                trustScore += 15;
            else
                reason += "\n- No return policy";



            if(invoice.getState())
                trustScore += 15;
            else
                reason += "\n- No invoice";



            if(oldSeller.getState())
                trustScore += 10;
            else
                reason += "\n- New seller";




            if(trustScore >= 60){


                output.setBackground(Color.GREEN);

                output.setForeground(Color.BLACK);


                output.setText(

                "SELLER VERIFIED ✅\n\n"+
                "Seller : "+seller.getText()+"\n"+
                "Platform : "+platform.getText()+"\n"+
                "Trust Score : "+trustScore+"%\n\n"+
                "You can proceed with secure payment."

                );


            }

            else{


                output.setBackground(Color.RED);

                output.setForeground(Color.WHITE);


                output.setText(

                "SELLER RISK DETECTED ❌\n\n"+
                "Trust Score : "+trustScore+"%\n\n"+
                "Reasons:"+reason

                );

            }

        }





        // Payment Hold

        if(e.getSource()==makePayment){



            if(trustScore >= 60){


                output.setBackground(Color.ORANGE);

                output.setForeground(Color.BLACK);



                output.setText(

                "PAYMENT STATUS: ON HOLD 🔒\n\n"+
                "Amount Received: $"+
                amount.getText()+"\n\n"+
                "Payment is secured.\n"+
                "Money is not released to seller.\n\n"+
                "Order Placed Successfully 📦\n\n"+
                "Waiting for delivery confirmation."

                );


            }

            else{


                output.setText(
                "Payment Blocked ❌\n"+
                "Seller verification failed.");

            }

        }





        // OTP Release

        if(e.getSource()==verifyOTP){



            if(otp.getText().equals(validOTP)
            && trustScore>=60){



                output.setBackground(Color.GREEN);

                output.setForeground(Color.BLACK);



                output.setText(

                "OTP VERIFIED ✅\n\n"+
                "Delivery Confirmed 📦\n\n"+
                "Payment Released Successfully 💰\n\n"+
                "Transaction Completed."

                );


            }

            else{


                output.setBackground(Color.RED);

                output.setForeground(Color.WHITE);



                output.setText(

                "INVALID OTP ❌\n\n"+
                "Payment Still Secured."

                );

            }

        }

    }



    public static void main(String args[]){

        new SecureBuy();

    }

}
