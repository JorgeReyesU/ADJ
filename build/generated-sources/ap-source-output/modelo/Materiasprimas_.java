package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Proveedores;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T15:24:36")
@StaticMetamodel(Materiasprimas.class)
public class Materiasprimas_ { 

    public static volatile SingularAttribute<Materiasprimas, Integer> matCodigo;
    public static volatile SingularAttribute<Materiasprimas, Integer> matCatidad;
    public static volatile SingularAttribute<Materiasprimas, Proveedores> proNIT;
    public static volatile SingularAttribute<Materiasprimas, String> matUnidadMedida;
    public static volatile SingularAttribute<Materiasprimas, String> matDescripcion;
    public static volatile SingularAttribute<Materiasprimas, String> matNombre;
    public static volatile SingularAttribute<Materiasprimas, Integer> matPrecioComprado;

}