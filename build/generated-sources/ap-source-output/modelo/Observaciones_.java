package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Empleados;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T15:24:36")
@StaticMetamodel(Observaciones.class)
public class Observaciones_ { 

    public static volatile SingularAttribute<Observaciones, Date> obsFecha;
    public static volatile SingularAttribute<Observaciones, Integer> obsCodigo;
    public static volatile SingularAttribute<Observaciones, Integer> obsEstado;
    public static volatile SingularAttribute<Observaciones, String> obsDescripcion;
    public static volatile SingularAttribute<Observaciones, Empleados> empDni;

}