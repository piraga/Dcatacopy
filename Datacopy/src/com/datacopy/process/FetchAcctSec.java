package com.datacopy.process;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.datacopy.dao.DataManager;

public class FetchAcctSec extends DataCopy implements FetchTables {
	
	private String acctId;
	private String secId;
	private String[] pstm = new String[2];
	private String[] pstmNo = new String[2];
	private String acctNo;
	private String secNo;
	
	DataManager dm = new DataManager();
	public FetchAcctSec(String acctId, String secId, boolean sviRad, boolean sviSeed, boolean sviTrd, boolean sviCli, boolean accountMaster,
			boolean secMaster, boolean caAcctSec, boolean caPayout, boolean caTerms, boolean caBroker, boolean corpAct,
			boolean hpsMaster, boolean hpsDetail, boolean stepUp) {
		
		super(sviRad, sviSeed, sviTrd, sviCli, accountMaster, secMaster, caAcctSec, caPayout, caTerms, caBroker, corpAct,
				hpsMaster, hpsDetail, stepUp);
		pstm[0]= this.acctId =acctId;
		pstm[1]= this.secId=secId;
		pstmNo[0]=acctNo=splitAcctId(acctId);
		pstmNo[1]=secNo=splitSecId(secId);
		
	}

	@Override
	public void processDataCopy() {
		
		processRad();
		processTrade();
		processSeed();
		processCli();
		processAccountMaster();
		processSecurityMaster();
		processCaAcctSec();
		processCorpActPayout();
		processCorpActTerms();
		processCorpActBroker();
		processCorpAct();
		processHpsMaster();
		processHpsDetail();
		processStepUp();		
		
	}

	@Override
	public void processRad() {
		
		int j=1;
		String query1 = null;
		try {
			
			System.out.println(acctId+"  "+secId+"  "+acctNo+"  "+secNo);
			ResultSet rs=dm.executeQueryByName("RAD", pstmNo);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			String query = "INSERT INTO "+ rsmd.getTableName(1)+" (";
			
			int columnCoun=rsmd.getColumnCount();
			for(int i=1;i<=columnCoun;i++) {
				
				query+=rsmd.getColumnName(i) ;
				if(i!=columnCoun)
				{
					query+=",";
				}
				String count = rsmd.getColumnName(i);
			}
			query+=") VALUES(";
			while(rs.next()) {
			
				for(int i=1;i<=columnCoun;i++) {
					query1+="'";
//				System.out.println(rsmd.getColumnTypeName(j));
				String count = rsmd.getColumnName(j);
//				System.out.println(count);
				if("DATE".equals(rsmd.getColumnTypeName(j))) {
					query1+="to_date(" + rs.getString(j)+"'"+ ",'MM/dd/yyyy')";
				}else if("NUMBER".equals(rsmd.getColumnTypeName(j))){
					query1+=rs.getInt(count);
				}else {
					query1+=rs.getString(count);
				}
				query1+="'";
				if(i!=columnCoun)
				query1+=",";
				j++;
			}
				j=1;
				query1+=");";
				System.out.println(query+" "+query1);
				query1=null;
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void processTrade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processSeed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCli() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processAccountMaster() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processSecurityMaster() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCaAcctSec() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCorpActPayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCorpActTerms() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCorpActBroker() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processCorpAct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processHpsMaster() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processHpsDetail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processStepUp() {
		// TODO Auto-generated method stub
		
	}
	
	
}
	