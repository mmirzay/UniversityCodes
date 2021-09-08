namespace KhabgaDaneshjooei
{
    partial class Rooms
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.txtRoomNum = new System.Windows.Forms.TextBox();
            this.cmbRoomCap = new System.Windows.Forms.ComboBox();
            this.cmbRoomType = new System.Windows.Forms.ComboBox();
            this.cmbRoomS = new System.Windows.Forms.ComboBox();
            this.btnSabt = new System.Windows.Forms.Button();
            this.btnEnseraf = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(133, 14);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(85, 20);
            this.label1.TabIndex = 0;
            this.label1.Text = "شماره اتاق:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(159, 44);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(59, 20);
            this.label2.TabIndex = 1;
            this.label2.Text = "ظرفیت:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(148, 73);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(70, 20);
            this.label3.TabIndex = 2;
            this.label3.Text = "نوع اتاق:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(89, 104);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(129, 20);
            this.label4.TabIndex = 3;
            this.label4.Text = "مختص دانشجویان:";
            // 
            // txtRoomNum
            // 
            this.txtRoomNum.Location = new System.Drawing.Point(12, 12);
            this.txtRoomNum.Name = "txtRoomNum";
            this.txtRoomNum.Size = new System.Drawing.Size(72, 22);
            this.txtRoomNum.TabIndex = 4;
            // 
            // cmbRoomCap
            // 
            this.cmbRoomCap.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbRoomCap.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cmbRoomCap.FormattingEnabled = true;
            this.cmbRoomCap.Items.AddRange(new object[] {
            "2",
            "4",
            "6",
            "8",
            "10",
            "16"});
            this.cmbRoomCap.Location = new System.Drawing.Point(12, 40);
            this.cmbRoomCap.Name = "cmbRoomCap";
            this.cmbRoomCap.Size = new System.Drawing.Size(72, 24);
            this.cmbRoomCap.TabIndex = 5;
            // 
            // cmbRoomType
            // 
            this.cmbRoomType.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbRoomType.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cmbRoomType.FormattingEnabled = true;
            this.cmbRoomType.Items.AddRange(new object[] {
            "اتاق",
            "سوئیت"});
            this.cmbRoomType.Location = new System.Drawing.Point(12, 69);
            this.cmbRoomType.Name = "cmbRoomType";
            this.cmbRoomType.Size = new System.Drawing.Size(72, 24);
            this.cmbRoomType.TabIndex = 6;
            // 
            // cmbRoomS
            // 
            this.cmbRoomS.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbRoomS.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cmbRoomS.FormattingEnabled = true;
            this.cmbRoomS.Items.AddRange(new object[] {
            "دختر",
            "پسر"});
            this.cmbRoomS.Location = new System.Drawing.Point(12, 100);
            this.cmbRoomS.Name = "cmbRoomS";
            this.cmbRoomS.Size = new System.Drawing.Size(72, 24);
            this.cmbRoomS.TabIndex = 7;
            // 
            // btnSabt
            // 
            this.btnSabt.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSabt.Location = new System.Drawing.Point(138, 148);
            this.btnSabt.Name = "btnSabt";
            this.btnSabt.Size = new System.Drawing.Size(75, 29);
            this.btnSabt.TabIndex = 8;
            this.btnSabt.Text = "ثبت";
            this.btnSabt.UseVisualStyleBackColor = true;
            this.btnSabt.Click += new System.EventHandler(this.btnSabt_Click);
            // 
            // btnEnseraf
            // 
            this.btnEnseraf.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEnseraf.Location = new System.Drawing.Point(57, 148);
            this.btnEnseraf.Name = "btnEnseraf";
            this.btnEnseraf.Size = new System.Drawing.Size(75, 29);
            this.btnEnseraf.TabIndex = 9;
            this.btnEnseraf.Text = "انصراف";
            this.btnEnseraf.UseVisualStyleBackColor = true;
            this.btnEnseraf.Click += new System.EventHandler(this.btnEnseraf_Click);
            // 
            // Rooms
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(224, 191);
            this.Controls.Add(this.btnEnseraf);
            this.Controls.Add(this.btnSabt);
            this.Controls.Add(this.cmbRoomS);
            this.Controls.Add(this.cmbRoomType);
            this.Controls.Add(this.cmbRoomCap);
            this.Controls.Add(this.txtRoomNum);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "Rooms";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Text = "ثبت اتاق";
            //this.Load += new System.EventHandler(this.Rooms_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtRoomNum;
        private System.Windows.Forms.ComboBox cmbRoomCap;
        private System.Windows.Forms.ComboBox cmbRoomType;
        private System.Windows.Forms.ComboBox cmbRoomS;
        private System.Windows.Forms.Button btnSabt;
        private System.Windows.Forms.Button btnEnseraf;
    }
}