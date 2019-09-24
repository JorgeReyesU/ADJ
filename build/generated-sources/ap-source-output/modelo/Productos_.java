package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Detallesorden;
import modelo.Proveedores;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-24T16:19:16")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, Proveedores> proNIT;
    public static volatile SingularAttribute<Productos, String> prodNombre;
    public static volatile SingularAttribute<Productos, Integer> prodPrecioVenta;
    public static volatile ListAttribute<Productos, Detallesorden> detallesordenList;
    public static volatile SingularAttribute<Productos, String> prodUnidadMedida;
    public static volatile SingularAttribute<Productos, String> prodDescripcion;
    public static volatile SingularAttribute<Productos, Integer> prodCodigo;
    public static volatile SingularAttribute<Productos, Integer> prodCantidad;
    public static volatile SingularAttribute<Productos, Integer> prodPrecioComprado;

}