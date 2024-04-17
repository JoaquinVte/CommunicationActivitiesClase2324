package es.ieslavereda.communicationactivitiesclase2324;

public enum Color implements Listable {
    BLACK(R.color.black,"Black"),
    WHITE(R.color.white,"White"),
    BLUE(R.color.blue,"Blue"),
    ORANGE(R.color.orange,"Orange"),
    GREEN(R.color.green,"Green"),
    RED(R.color.red,"Red"),
    DEFAULT(com.google.android.material.R.color.design_default_color_primary, "Default");


    private int value;
    private String nombre;

    Color(int value, String nombre) {
        this.value = value;
        this.nombre = nombre;
    }

    public int getValue() {
        return value;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDescription() {
        return getNombre();
    }

    @Override
    public int getDrawableSimbol() {
        return getValue();
    }

    @Override
    public int getDrawableImage() {
        return getValue();
    }
}
