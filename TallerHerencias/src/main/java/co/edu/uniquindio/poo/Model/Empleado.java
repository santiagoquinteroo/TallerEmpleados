package co.edu.uniquindio.poo.Model;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Empleado {
    private final String nombre;
    private final String documento;
    private int edad;
    private final float salarioBase;
    private CategoriaEmpleado categoria;
    private float descuentoSalud;
    private float descuentoPension;

    private ArrayList<EmpleadoPlanta> empleadosPlanta;
    private ArrayList<EmpleadoTemporal> empleadosTemporal;
    private ArrayList<EmpleadoVentas> empleadosVentas;


    public Empleado(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud,
                    float descuentoPension, ArrayList<EmpleadoPlanta> empleadosPlanta,
                    ArrayList<EmpleadoTemporal> empleadosTemporal, ArrayList<EmpleadoVentas> empleadosVentas) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
        this.empleadosPlanta = empleadosPlanta;
        this.empleadosTemporal = empleadosTemporal;
        this.empleadosVentas = empleadosVentas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public CategoriaEmpleado getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEmpleado categoria) {
        this.categoria = categoria;
    }

    public float getDescuentoSalud() {
        return descuentoSalud;
    }

    public void setDescuentoSalud(float descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    public float getDescuentoPension() {
        return descuentoPension;
    }

    public void setDescuentoPension(float descuentoPension) {
        this.descuentoPension = descuentoPension;
    }
    public double calcularBonificacion(){
        double bonificacion = 0;
        CategoriaEmpleado categoria = getCategoria();
        if (categoria == CategoriaEmpleado.JUNIOR){
            bonificacion = 0.05;
        } else if (categoria == CategoriaEmpleado.SEMI_SENIOR) {
            bonificacion = 0.10;
        } else if (categoria == CategoriaEmpleado.SENIOR){
            bonificacion = 0.15;
        } else bonificacion = 0;

        return  bonificacion;

    }
    public double calcularDescuento(){
        double descuentos = descuentoPension+descuentoSalud;
        return descuentos;
    }

    public abstract float calcularSalarioBruto();

    public float calcularSalarioNeto(){
        float salarioNeto = (float) (calcularSalarioBruto()-(calcularSalarioBruto()*calcularDescuento()));
        if (salarioNeto>0 && calcularBonificacion()!=0) {
            return salarioNeto;
        }else return 0;
    }

    public abstract ResumenPago resumenPago();


    public void mostrarInformacion(){
        JOptionPane.showMessageDialog(null,
                "Nombre: "+getNombre()
                +"\n Documento: "+getDocumento()
                +"\n Edad: "+getEdad()
                +"\n Categoria: "+getCategoria()
                +"\n Salario base: "+getSalarioBase()
                +"\n Descuento por pension: "+getDescuentoPension()
                +"\n Descuento por salud: "+getDescuentoSalud()
                +"\n Bonificación: "+calcularBonificacion()*100+"%"
                +"\n Salario neto: "+calcularSalarioNeto());
    }

}
