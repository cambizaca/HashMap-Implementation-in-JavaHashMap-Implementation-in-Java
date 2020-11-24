package assignment3_f20;

public class HashMap_imp implements HashMap { 
	  HMCell[] tab;
	  int nelts;
	  
	  //-------------------------------------------------------------

	  HashMap_imp (int num) { 
	    this.tab = new HMCell[num];
	    // for (int i=0; i<num; i++) { tab[i] = null; }
	    // we can rely on the Java compiler to fill the table array with nulls
	    // another way would be Array.fill()
	    this.nelts = 0; 
	  }

	  //-------------------------------------------------------------
	  
	  public int hash (String key, int tabSize) {
	    int hval = 7;
	    for (int i=0; i<key.length(); i++) {
	      hval = (hval*31) + key.charAt(i);
	    }
	    hval = hval % tabSize;
	    if (hval<0) { hval += tabSize; }
	    return hval;
	  }
	  
	  //-------------------------------------------------------------

	  // Don't change 
	  @Override
	  public HMCell[] getTable() { 
//			for(int i = 0; i < tab.length; i++) {
//				if(tab[i] != null) {
//					if (tab[i].getNext() == null)  {
//						System.out.println("new hash map, at index " + i + " we got " + tab[i].getKey());
//					} else {
//						String keys = "";
//						HMCell refCell = tab[i];
//						while(refCell != null) {
//							keys += refCell.getKey() + ", "; 
//						//	System.out.println(tab[i].getKey());
//							refCell = refCell.getNext();
//						}
//						System.out.println("new hash map, at index " + i + " we got " + keys);
//
//					}
//					
//				} else { 
//					System.out.println("new hash map, at index " + i + " we got " + tab[i]);
//				}
//			}
//			System.out.println("END TABLE");

		  return this.tab; 
	  }

	@Override
	public Value put(String k, Value v) {
		if(tab[hash(k, tab.length)] == null) {
			tab[hash(k, tab.length)] = new HMCell_imp(k,v);
			nelts++;
			if(this.lambda() >= 1) {
				this.extend();
			}
			return null;
		} else if(tab[hash(k, tab.length)] != null) {								// Something is at index
			HMCell refCell = tab[hash(k, tab.length)];
				while(refCell != null) {											// multi chains, starts at first cell and iterates through other cells 
						if(k.compareTo(tab[hash(k, tab.length)].getKey()) == 0) {					// if key is inside chain, change HMCell
							Value old_v = tab[hash(k, tab.length)].getValue();
							refCell.setValue(v);									// else just insert new HMCell next to old HMCell chain 										// ex put("I", blah)
							return old_v;											// Chain: (huh, nope)--- (I, hi) --> (huh, nope)---(I, blah)
						} else if (tab[hash(k, tab.length)].getNext() == null) {
							tab[hash(k, tab.length)].setNext(new HMCell_imp(k,v));					//if not in chain, simply add at end of chain-link		
							nelts++;
								if(this.lambda() >= 1) {
									this.extend();
								}	
							return null;	
						}															//System.out.println("Made it hereee");
						tab[hash(k, tab.length)].getNext();
						refCell.getNext();
;					}
		}
		return null;
	}

	@Override
	public Value get(String k) {
		if(tab[hash(k, tab.length)] == null) {
			return null;
		} else {
			while(tab[hash(k, tab.length)] != null) {
				if(k.compareTo(tab[hash(k, tab.length)].getKey()) == 0) {
					return tab[hash(k, tab.length)].getValue();
				}
				tab[hash(k, tab.length)] = tab[hash(k, tab.length)].getNext();
			}
			
		}
		return null;
	}

	
	
	@Override
	public void remove(String k) {
		// TODO Auto-generated method stub
		if(tab[hash(k, tab.length)] == null) {
			return;
		} 
		HMCell refCell = tab[hash(k, tab.length)];
		if(refCell.getNext() == null) {
			if(k.compareTo(refCell.getKey()) == 0) {				
				tab[hash(k, tab.length)] = null;
				nelts--;
				return;
			}
		} 
		HMCell pCell = refCell;
		if(pCell != null) {
			if(k.compareTo(refCell.getKey()) == 0) {
				tab[hash(k, tab.length)] = pCell.getNext();
				nelts--;
				return;
			}
		}
		HMCell cCell = pCell.getNext();
			while(cCell != null) {	
				if(k.compareTo(cCell.getKey()) == 0) {
					if(cCell.getNext() == null) {
						cCell = null;
						pCell.setNext(null);
						tab[hash(k, tab.length)] = pCell;
						nelts--;
						return;
					} else {
						/* unlinks chain from cCell to cCell.next
						and then sets pCell.next to cCell.next 
						effectively getting rid of cCell
						 */
						HMCell newCCell = cCell.getNext();
						cCell = null;
						pCell.setNext(newCCell);
						tab[hash(k, tab.length)] = pCell;
						nelts--;
						return;
					}
				}
			pCell = cCell;
			cCell = cCell.getNext();
		}
	}


	
	@Override
	public boolean hasKey(String k) {
		if(tab[hash(k, tab.length)] == null) {
			return false;
		}
		HMCell refCell = tab[hash(k, tab.length)];
			while(refCell != null) {	
				if(k.compareTo(refCell.getKey()) == 0) {
					return true;
				}
				refCell = tab[hash(k, tab.length)].getNext();
		}
		return false;
	}

	@Override
	public int size() {
		return nelts;
	}

	@Override
	public String maxKey() {
		// TODO Auto-generated method stub
		for(int i = tab.length - 1; i >= 0; i-- ) {
			if(tab[i] != null) {
					return tab[i].getKey();
				}
			}
		return null;
	}

	@Override
	public String minKey() {
		for(int i = 0; i < tab.length; i++ ) {
			if(tab[i] != null) {
					return tab[i].getKey();
			}
		}
		return null;
	}
	

	@Override
	public String[] getKeys() {
		String[] keys = new String[nelts];
		int k = 0;
		int indTab = 0;
		if(nelts == 0) {
			return keys;
		}
		while(indTab < tab.length) {
			if (k < nelts) {
				if(tab[indTab] != null) {
					HMCell refCell = tab[indTab];
					if(tab[indTab].getNext() == null) {
						keys[k] = tab[indTab].getKey();
						k++;
					} 
					else if(refCell.getNext() != null)  {
						while(refCell != null) {
							keys[k] = refCell.getKey();
							refCell = refCell.getNext();
							k++;
						}
					}
				}
			}
			indTab++;
		}
			return keys;
	}

	public double lambda() {
		return (double) nelts/tab.length;
		
	}

	@Override
	public double extend() {
		HMCell[] tab_temp = new HMCell[tab.length * 2];
		for(int i = 0; i < tab.length; i++) {
			if(tab[i] != null) {
				if(tab[i].getNext() != null) {
					HMCell refCell = tab[i];
					while(refCell != null ) {
						tab_temp[hash(refCell.getKey(), tab_temp.length)] = refCell;
						refCell = refCell.getNext();
					}
				} else {
					tab_temp[hash(tab[i].getKey(), tab_temp.length)] = tab[i];
				}
			}
		}
		tab = tab_temp;	
		for(int i  = 0; i < tab.length; i++) {
			if(tab[i] != null) {
				if(tab[i].getNext() != null) {
					tab[i].setNext(null);
				}
			}
		}
		return this.lambda();

	}
	  
	  //-------------------------------------------------------------

	    
	  //-------------------------------------------------------------
	  // here down... you fill in the implementations for
	  // the other interface methods
	  //-------------------------------------------------------------
	  
	
}
