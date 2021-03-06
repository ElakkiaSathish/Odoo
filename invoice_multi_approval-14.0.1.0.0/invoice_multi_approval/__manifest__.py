# -*- coding: utf-8 -*-
#############################################################################

#
#############################################################################
{
    'name': "Invoice Multi level Approval",
    'version': '14.0.1.0.0',
    'summary': """This module add the multiple approval option for invoice,
    			  bill,refund and credit notes.""",
    'description': """This module add the multiple approval option for invoice,
    bill,refund and credit notes.""",
    'category': 'Accounting',
    
    'maintainer': 'Elakkia',
    
    'depends': ['account'],
    'data': [
        'data/data.xml',
        'security/groups.xml',
        'security/ir.model.access.csv',
        'views/invoice_approval_view.xml',
        'views/account_move_inherited.xml',
    ],
    'license': "AGPL-3",
    'images': ['static/description/banner.png'],
    'installable': True,
    'application': True,
}
