package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Accounts;
import modelo.Observaciones;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-24T20:31:40")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile SingularAttribute<Empleados, Date> empFechaDespido;
    public static volatile ListAttribute<Empleados, Accounts> accountsList;
    public static volatile SingularAttribute<Empleados, String> empNombre;
    public static volatile SingularAttribute<Empleados, String> empApellido;
    public static volatile ListAttribute<Empleados, Observaciones> observacionesList;
    public static volatile SingularAttribute<Empleados, Integer> empSalario;
    public static volatile SingularAttribute<Empleados, Date> empFechaNacimiento;
    public static volatile SingularAttribute<Empleados, Integer> empDni;
    public static volatile SingularAttribute<Empleados, Date> empFechaContratacion;
    public static volatile SingularAttribute<Empleados, Character> empGenero;
    public static volatile SingularAttribute<Empleados, String> empCargo;

}