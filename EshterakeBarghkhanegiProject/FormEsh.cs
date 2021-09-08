using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;


namespace tamrine_11
{
    public partial class FormEsh : Form
    {
        long clientNumber = 10000;
        public FormEsh()
        {
            InitializeComponent();
        }
       

        public void writeTofile(String str0,String str1, String str2, String str3,String str4,String str5,String str6,String cnum,String fn)
        {
            String fileName = fn;
            FileStream fs = new FileStream(fileName+".txt", FileMode.Append, FileAccess.Write);
            StreamWriter sr = new StreamWriter(fs);
            if(str0.Equals("home"))
                sr.WriteLine(cnum+","+str1 + "," + str2 + "," +str3 +"," + str4 + "," + str5+","+str6);
            else
                sr.WriteLine(cnum + "," + str1 + "," + str2 + "," + str3 + "," + str4 + "," + str5);
            sr.Close();
            fs.Close();
        }
        public long writeUserPass(String ut)
        {
            long newClientNumber = 10000;
            FileStream fsr = new FileStream("user_account.txt", FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader srr = new StreamReader(fsr);
            string line = srr.ReadLine();
            while (line != null)
            {
                string[] client=line.Split(',');
                if (newClientNumber.ToString().Equals(client[0]))
                    newClientNumber++;
                line = srr.ReadLine();
            }
            srr.Close();
            fsr.Close();
            FileStream fsw = new FileStream("user_account.txt", FileMode.Append, FileAccess.Write);
            StreamWriter srw = new StreamWriter(fsw);
            clientNumber = newClientNumber;
            srw.WriteLine(newClientNumber + "," + "p" + clientNumber+","+ut);            
            srw.Close();
            fsw.Close();
            return newClientNumber;
        }
       

        private void bnSabt_Click(object sender, EventArgs e)
        {
            if (rdbtnHome.Checked == true)
            {
                if (id_txtBox.Text.Equals("") || name_txtBox.Text.Equals("") ||
                    lastName_txtBox.Text.Equals("") || tell_txtBox.Text.Equals("") ||
                    txtPostalCode.Text.Equals("") || txtUnit.Text.Equals(""))
                    MessageBox.Show("لطفا اطلاعات را کامل وارد کنید!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                else
                {
                    String id = id_txtBox.Text;
                    String name = name_txtBox.Text;
                    String lastName = lastName_txtBox.Text;
                    String postCode = txtPostalCode.Text;
                    String tell = tell_txtBox.Text;
                    String unit = txtUnit.Text;
                    long strClient=writeUserPass("homeUser");
                    writeTofile("home", name, lastName, id, postCode, tell,unit,clientNumber.ToString(), "home_suppliant");
                    MessageBox.Show("اطلاعات شما ثبت شد. نام کاربری و رمز عبور شما به قرار زیر است:\n\n نام کاربری: " + strClient + "\n رمز عبور: p" + strClient + "\n\n لطفا این اطلاعات را یادداشت فرمایید.",
                        "ثبت اطلاعات", MessageBoxButtons.OK, MessageBoxIcon.Information,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                    clientNumber++;
                    this.Close();
                }
            }
            else {
                if (txtOrgName.Text.Equals("") || cmbOrgType.Text.Equals("") ||
                    txtOrgPost.Text.Equals("") || txtOrgNamayande.Text.Equals("") ||
                    txtOrgTel.Text.Equals(""))
                    MessageBox.Show("لطفا اطلاعات را کامل وارد کنید!", "خطا", MessageBoxButtons.OK, MessageBoxIcon.Error,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                else
                {
                    String strOrgName = txtOrgName.Text;
                    String strOrgType = cmbOrgType.Text;
                    String strOrgPost = txtOrgPost.Text;
                    String strOrgNamayande = txtOrgNamayande.Text;
                    String strOrgTel = txtOrgTel.Text;
                    long strClient = writeUserPass("orgUser");
                    writeTofile("org", strOrgName, strOrgType, strOrgPost, strOrgNamayande,strOrgTel,null,clientNumber.ToString(),"organization_suppliant");
                    MessageBox.Show("اطلاعات شما ثبت شد. نام کاربری و رمز عبور شما به قرار زیر است:\n\n نام کاربری: " + strClient + "\n رمز عبور: p" + strClient+"\n\n لطفا این اطلاعات را یادداشت فرمایید.",
                        "ثبت اطلاعات", MessageBoxButtons.OK, MessageBoxIcon.Information,
                        MessageBoxDefaultButton.Button1, MessageBoxOptions.RtlReading, false);
                    clientNumber++;
                    this.Close();
                }
            }
        }

        private void FormEsh_Load(object sender, EventArgs e)
        {
            rdbtnHome.Checked = true;            
        }


        private void rbnsaz_CheckedChanged(object sender, EventArgs e)
        {
            gbOrg.Visible = true;            
        }

        private void rdbtnHome_CheckedChanged(object sender, EventArgs e)
        {           
            gbOrg.Visible = false;
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        

      

    }
}
