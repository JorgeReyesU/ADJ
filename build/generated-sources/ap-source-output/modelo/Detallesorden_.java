package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Ordenes;
import modelo.Productos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T15:24:36")
@StaticMetamodel(Detallesorden.class)
public class Detallesorden_ { 

    public static volatile SingularAttribute<Detallesorden, Integer> detCantidad;
    public static volatile SingularAttribute<Detallesorden, String> detDescripcion;
    public static volatile SingularAttribute<Detallesorden, Integer> detCodigo;
    public static volatile SingularAttribute<Detallesorden, Ordenes> ordCodigo;
    public static volatile SingularAttribute<Detallesorden, Productos> prodCodigo;

}