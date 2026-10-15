package co.edu.uniquindio.poo.Model;

import javax.swing.*;
import java.util.ArrayList;

public class EmpleadoPlanta extends Empleado{
    private String cargo;
    private int horasExtra;
    private float valorHorasExtra;
    private float auxilioTransporte;


    public EmpleadoPlanta(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud,
                          float descuentoPension, ArrayList<EmpleadoPlanta> empleadosPlanta, ArrayList<EmpleadoTemporal> empleadosTemporal,
                          ArrayList<EmpleadoVentas> empleadosVentas, String cargo, int horasExtra, float valorHorasExtra, float auxilioTransporte) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension, empleadosPlanta, empleadosTemporal, empleadosVentas);
        this.cargo = cargo;
        this.horasExtra = horasExtra;
        this.valorHorasExtra = valorHorasExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public float getValorHorasExtra() {
        return valorHorasExtra;
    }

    public void setValorHorasExtra(float valorHorasExtra) {
        this.valorHorasExtra = valorHorasExtra;
    }

    public float getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(float auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }


    @Override
    public float calcularSalarioBruto() {
        float salarioBruto = (float) (getSalarioBase() + ((getSalarioBase()*calcularBonificacion())+(getSalarioBase()+
                (horasExtra*valorHorasExtra))-(auxilioTransporte)));
        if (salarioBruto>=0) {
            return salarioBruto;
        }else return 0;
    }

    @Override
    public double calcularBonificacion() {
        return super.calcularBonificacion();
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        JOptionPane.showMessageDialog(null, "INFORMACIÓN DEL EMPLEADO DE PLANTA: \n"
                +"Cargo: "+getCargo()
                +"Horas extra: "+getHorasExtra());

    }

    @Override
    public ResumenPago resumenPago() {
        return new ResumenPago(documento, nombre, resumenPago().tipoEmpleado(), )
    }
}
