namespace tamrine_11
{
    partial class SuppList
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
            this.tcShow = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.dgvHome = new System.Windows.Forms.DataGridView();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.dgvOrg = new System.Windows.Forms.DataGridView();
            this.btnConfirm = new System.Windows.Forms.Button();
            this.btnCancel = new System.Windows.Forms.Button();
            this.tcShow.SuspendLayout();
            this.tabPage1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvHome)).BeginInit();
            this.tabPage2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvOrg)).BeginInit();
            this.SuspendLayout();
            // 
            // tcShow
            // 
            this.tcShow.Controls.Add(this.tabPage1);
            this.tcShow.Controls.Add(this.tabPage2);
            this.tcShow.Location = new System.Drawing.Point(12, 12);
            this.tcShow.Name = "tcShow";
            this.tcShow.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.tcShow.RightToLeftLayout = true;
            this.tcShow.SelectedIndex = 0;
            this.tcShow.Size = new System.Drawing.Size(655, 263);
            this.tcShow.SizeMode = System.Windows.Forms.TabSizeMode.Fixed;
            this.tcShow.TabIndex = 0;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.dgvHome);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(647, 237);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "متقاضیان خانگی";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // dgvHome
            // 
            this.dgvHome.AllowUserToAddRows = false;
            this.dgvHome.AllowUserToDeleteRows = false;
            this.dgvHome.AllowUserToResizeColumns = false;
            this.dgvHome.AllowUserToResizeRows = false;
            this.dgvHome.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvHome.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvHome.Location = new System.Drawing.Point(0, 0);
            this.dgvHome.MultiSelect = false;
            this.dgvHome.Name = "dgvHome";
            this.dgvHome.ReadOnly = true;
            this.dgvHome.RowHeadersWidthSizeMode = System.Windows.Forms.DataGridViewRowHeadersWidthSizeMode.DisableResizing;
            this.dgvHome.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvHome.Size = new System.Drawing.Size(647, 237);
            this.dgvHome.TabIndex = 0;
            this.dgvHome.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvHome_CellClick);
            this.dgvHome.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvHome_CellContentClick);
            this.dgvHome.SelectionChanged += new System.EventHandler(this.dgvHome_SelectionChanged);
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.dgvOrg);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(647, 237);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "متقاضیان سازمانی";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // dgvOrg
            // 
            this.dgvOrg.AllowUserToAddRows = false;
            this.dgvOrg.AllowUserToDeleteRows = false;
            this.dgvOrg.AllowUserToResizeColumns = false;
            this.dgvOrg.AllowUserToResizeRows = false;
            this.dgvOrg.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvOrg.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvOrg.Location = new System.Drawing.Point(0, 0);
            this.dgvOrg.MultiSelect = false;
            this.dgvOrg.Name = "dgvOrg";
            this.dgvOrg.ReadOnly = true;
            this.dgvOrg.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvOrg.Size = new System.Drawing.Size(647, 237);
            this.dgvOrg.TabIndex = 0;
            this.dgvOrg.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvOrg_CellClick);
            this.dgvOrg.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvOrg_CellContentClick);
            this.dgvOrg.SelectionChanged += new System.EventHandler(this.dgvOrg_SelectionChanged);
            // 
            // btnConfirm
            // 
            this.btnConfirm.Location = new System.Drawing.Point(588, 290);
            this.btnConfirm.Name = "btnConfirm";
            this.btnConfirm.Size = new System.Drawing.Size(75, 23);
            this.btnConfirm.TabIndex = 1;
            this.btnConfirm.Text = "تایید اشتراک";
            this.btnConfirm.UseVisualStyleBackColor = true;
            this.btnConfirm.Click += new System.EventHandler(this.btnConfirm_Click);
            // 
            // btnCancel
            // 
            this.btnCancel.Location = new System.Drawing.Point(12, 290);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(75, 23);
            this.btnCancel.TabIndex = 2;
            this.btnCancel.Text = "بستن";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // SuppList
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(679, 325);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnConfirm);
            this.Controls.Add(this.tcShow);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "SuppList";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "لیست متقاضیان";
            this.Load += new System.EventHandler(this.SuppList_Load);
            this.tcShow.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgvHome)).EndInit();
            this.tabPage2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgvOrg)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tcShow;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.DataGridView dgvHome;
        private System.Windows.Forms.DataGridView dgvOrg;
        private System.Windows.Forms.Button btnConfirm;
        private System.Windows.Forms.Button btnCancel;

    }
}