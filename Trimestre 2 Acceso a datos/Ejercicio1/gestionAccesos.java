public class GestorBD {
    private static final String PERSISTENCE_UNIT_NAME = "alumnos";
    private static EntityManagerFactory factory;

    public static void insertarAlumno(Alumno alumno) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        em.close();
    }

    public static void listarTodo() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT a FROM Alumno a");
        List<Alumno> alumnos = (List<Alumno>) query.getResultList();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombre() + " " + alumno.getNotaAD() + " " + alumno.getNotaDI());
        }
        em.close();
    }

    public static void listarSuspensos() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT a FROM Alumno a WHERE a.notaAD < 5 OR a.notaDI < 5");
        final List<Alumno> alumnos = (List<Alumno>)}

    public static String getPersistenceUnitName() {
        return PERSISTENCE_UNIT_NAME;
    }

    public static EntityManagerFactory getFactory() {
        return factory;
    }

    public static void setFactory(EntityManagerFactory factory) {
        GestorBD.factory = factory;
    }
}