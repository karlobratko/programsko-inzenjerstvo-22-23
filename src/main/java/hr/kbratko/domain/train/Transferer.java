package hr.kbratko.domain.train;

import hr.kbratko.domain.vehicle.Transferable;
import java.util.List;

public interface Transferer extends Limitable, Revenuable {
  List<Transferable> getTransferables();

  Boolean addTransferable(Transferable transferable);

  Boolean removeTransferable(Transferable transferable);
}
