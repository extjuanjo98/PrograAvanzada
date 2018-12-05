with Text_IO;
with Monitor;
use Monitor;

procedure Main is

   task type Escribir;
   task type Leer;
   gestor : TGestor;

   task body Leer is
   begin
      gestor.iniciarLectura;
      gestor.terminarLectura;
   end Leer;

   task body Escribir is
   begin
      gestor.iniciarEscritura;
      gestor.terminarEscritura;
   end Escribir;

   procedure Lanzar is
      e1,e2,e3,e4:Escribir;
      le1,le2,le3,le4,le5,le6,le7,le8,le9,le10:Leer;
   begin
      null;
   end Lanzar;

begin
 lanzar;
end Main;
