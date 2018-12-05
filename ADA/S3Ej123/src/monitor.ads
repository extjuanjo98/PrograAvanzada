package Monitor is

protected type Moni is
      procedure incrementa;
      procedure write(valor:Integer);
      function read return Integer;
   private
      contador:Integer;
   end Moni;

end Monitor;
