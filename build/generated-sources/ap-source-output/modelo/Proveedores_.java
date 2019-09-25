package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Materiasprimas;
import modelo.Productos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-24T20:31:40")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, String> proTelefono;
    public static volatile SingularAttribute<Proveedores, String> proDireccion;
    public static volatile SingularAttribute<Proveedores, String> proNIT;
    public static volatile SingularAttribute<Proveedores, String> proNombre;
    public static volatile ListAttribute<Proveedores, Productos> productosList;
    public static volatile ListAttribute<Proveedores, Materiasprimas> materiasprimasList;
    public static volatile SingularAttribute<Proveedores, String> proEmail;

}