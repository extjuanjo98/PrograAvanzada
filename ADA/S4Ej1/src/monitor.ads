package Monitor is
  protected type TGestor is
      entry iniciarLectura;
      procedure terminarLectura;
      entry iniciarEscritura;
      procedure terminarEscritura;

   private
      turnoLectura : Boolean := False;
      escribiendo : Boolean := False;
      nLectores : Integer := 0;
   end TGestor;
end Monitor;
