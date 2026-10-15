package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;

public class EmpleadoVentas extends Empleado {
    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension,
                          ArrayList<EmpleadoPlanta> empleadosPlanta, ArrayList<EmpleadoTemporal> empleadosTemporal, ArrayList<EmpleadoVentas> empleadosVentas,
                          float totalVentas, float porcentajeComision) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension, empleadosPlanta, empleadosTemporal, empleadosVentas);
        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }

    public float getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(float totalVentas) {
        this.totalVentas = totalVentas;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public float calcularSalarioBruto() {
        float salarioBruto = (float) (getSalarioBase() + (getSalarioBase()*calcularBonificacion())+(getSalarioBase()*(porcentajeComision/100)));
        if (salarioBruto>=0){
            return salarioBruto;
        }else return 0;
    }

    @Override
    public ResumenPago resumenPago() {
        return "";
    }

    @Override
    public double calcularBonificacion() {
        return super.calcularBonificacion();
    }
}
