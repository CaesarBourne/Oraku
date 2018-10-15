package com.example.caesar.opellaapp;

import com.cooltechworks.creditcarddesign.CardSelector;

public class OrakuCardSelector {
    public static final CardSelector VISA;
    public static final CardSelector MASTER;
    public static final CardSelector AMEX;
    public static final CardSelector DEFAULT;
    private static final String PREFIX_AMEX = "50";
    private static final char PREFIX_VISA = '4';
    private static final String PREFIX_MASTER = "51,52,53,54,55,";
    public static final int CVV_LENGHT_DEFAULT = 3;
    public static final int CVV_LENGHT_AMEX = 3;
    private int mResCardId;
    private int mResChipOuterId;
    private int mResChipInnerId;
    private int mResCenterImageId;
    private int mResLogoId;
    private int mCvvLength = 3;



    public int getResCardId() {
        return this.mResCardId;
    }

    public void setResCardId(int mResCardId) {
        this.mResCardId = mResCardId;
    }

    public int getResChipOuterId() {
        return this.mResChipOuterId;
    }

    public void setResChipOuterId(int mResChipOuterId) {
        this.mResChipOuterId = mResChipOuterId;
    }

    public int getResChipInnerId() {
        return this.mResChipInnerId;
    }

    public void setResChipInnerId(int mResChipInnerId) {
        this.mResChipInnerId = mResChipInnerId;
    }

    public int getResCenterImageId() {
        return this.mResCenterImageId;
    }

    public void setResCenterImageId(int mResCenterImageId) {
        this.mResCenterImageId = mResCenterImageId;
    }

    public int getResLogoId() {
        return this.mResLogoId;
    }

    public void setResLogoId(int mResLogoId) {
        this.mResLogoId = mResLogoId;
    }

    public int getCvvLength() {
        return this.mCvvLength;
    }

    public void setCvvLength(int mCvvLength) {
        this.mCvvLength = mCvvLength;
    }

    public static CardSelector selectCard(char cardFirstChar) {
        switch(cardFirstChar) {
            case '3':
                return AMEX;
            case '4':
                return VISA;
            case '5':
                return MASTER;
            default:
                return DEFAULT;
        }
    }

    public static CardSelector selectCard(String cardNumber) {
        if (cardNumber != null && cardNumber.length() >= 3) {
            CardSelector selector = selectCard(cardNumber.charAt(0));
            if (selector != DEFAULT) {
                int[] drawables = new int[]{com.cooltechworks.creditcarddesign.R.drawable.card_color_round_rect_brown, com.cooltechworks.creditcarddesign.R.drawable.card_color_round_rect_green, com.cooltechworks.creditcarddesign.R.drawable.card_color_round_rect_pink, com.cooltechworks.creditcarddesign.R.drawable.card_color_round_rect_purple, com.cooltechworks.creditcarddesign.R.drawable.card_color_round_rect_blue};
                int hash = cardNumber.substring(0, 3).hashCode();
                if (hash < 0) {
                    hash *= -1;
                }

                int index = hash % drawables.length;
                int chipIndex = hash % 3;
                int[] chipOuter = new int[]{com.cooltechworks.creditcarddesign.R.drawable.chip, com.cooltechworks.creditcarddesign.R.drawable.chip_yellow, 17170445};
                int[] chipInner = new int[]{com.cooltechworks.creditcarddesign.R.drawable.chip_inner, com.cooltechworks.creditcarddesign.R.drawable.chip_yellow_inner, 17170445};
                selector.setResCardId(drawables[index]);
                selector.setResChipOuterId(chipOuter[chipIndex]);
                selector.setResChipInnerId(chipInner[chipIndex]);
                return selector;
            }
        }

        return DEFAULT;
    }

    static {
        VISA = new CardSelector(com.cooltechworks.creditcarddesign.R.drawable.card_color_round_rect_purple, com.cooltechworks.creditcarddesign.R.drawable.chip, com.cooltechworks.creditcarddesign.R.drawable.chip_inner, 17170445, com.cooltechworks.creditcarddesign.R.drawable.ic_billing_visa_logo, 3);
        MASTER = new CardSelector(com.cooltechworks.creditcarddesign.R.drawable.card_color_round_rect_pink, com.cooltechworks.creditcarddesign.R.drawable.chip_yellow, com.cooltechworks.creditcarddesign.R.drawable.chip_yellow_inner, 17170445, com.cooltechworks.creditcarddesign.R.drawable.ic_billing_mastercard_logo, 3);
        AMEX = new CardSelector(com.cooltechworks.creditcarddesign.R.drawable.card_color_round_rect_green, 17170445, 17170445, R.drawable.vervec, com.cooltechworks.creditcarddesign.R.drawable.ic_billing_amex_logo1, 4);
        DEFAULT = new CardSelector(com.cooltechworks.creditcarddesign.R.drawable.card_color_round_rect_default, com.cooltechworks.creditcarddesign.R.drawable.chip, com.cooltechworks.creditcarddesign.R.drawable.chip_inner, 17170445, 17170445, 3);
    }
}
