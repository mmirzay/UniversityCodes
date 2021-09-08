using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace KhabgaDaneshjooei
{
    public partial class Rooms : Form
    {
        public Rooms()
        {
            InitializeComponent();
        }

        private void btnEnseraf_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnSabt_Click(object sender, EventArgs e)
        {
            Room r = new Room();
            r._RoomNum = txtRoomNum.Text; r._RoomCap = cmbRoomCap.Text;
            r._RoomType = cmbRoomType.Text; r._RoomS = cmbRoomS.Text;
            if (r._RoomNum.Equals("") || r._RoomCap.Equals("") || r._RoomType.Equals("") || r._RoomS.Equals(""))
                MessageBox.Show(".اطلاعات را کامل وارد کنید", "اخطار", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
            {
                r.saveRoom();
                MessageBox.Show(".اطلاعات ذخیره شد", "ذخیره سازی", MessageBoxButtons.OK, MessageBoxIcon.Information);
                this.Close();
            }
        }
    }
}
